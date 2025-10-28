import os
import sys
import time

# sneak_game.py
# A simple terminal stealth game: move (WASD), crouch (C), wait (.), reach the goal (G) without being seen.
# Run: python sneak_game.py


WIDTH, HEIGHT = 20, 12

MAP_TEMPLATE = [
    "####################",
    "#......#.....#.....#",
    "#..##..#..##.#.##..#",
    "#..##..#..##.#.##..#",
    "#......#...........#",
    "#.####.####.######.#",
    "#.#........#......G#",
    "#.#.######.#.##.##.#",
    "#.#......#.#.##.##.#",
    "#.######.#.#......#.",
    "#........#........#",
    "####################",
]

# Player start
PLAYER_START = (1, 10)  # (x, y)

# Guards: each has a list of patrol points (x,y)
GUARD_PATROLS = [
    [(9, 2), (14, 2), (14, 4), (9, 4)],
    [(5, 6), (5, 8), (8, 8), (8, 6)],
    [(15, 7), (15, 9), (12, 9), (12, 7)],
]

SIGHT_RANGE = 6  # how many tiles a guard can see
TICK_SLEEP = 0.05  # small pause to make output readable


def clear():
    os.system("cls" if os.name == "nt" else "clear")


class Guard:
    def __init__(self, patrol):
        self.patrol = patrol[:]
        self.i = 0
        self.pos = patrol[0]
        self.next_index = 1 if len(patrol) > 1 else 0

    def step(self, game_map):
        if len(self.patrol) < 2:
            return
        target = self.patrol[self.next_index]
        x, y = self.pos
        tx, ty = target
        dx = 0 if tx == x else (1 if tx > x else -1)
        dy = 0 if ty == y else (1 if ty > y else -1)
        # move preference: horizontal then vertical
        cand = (x + dx, y) if dx != 0 else (x, y + dy)
        if game_map.is_walkable(cand):
            self.pos = cand
        else:
            # try other direction if blocked
            cand2 = (x, y + dy)
            if game_map.is_walkable(cand2):
                self.pos = cand2
        if self.pos == target:
            self.i = self.next_index
            self.next_index = (self.next_index + 1) % len(self.patrol)

    def facing_vector(self):
        # face toward next patrol point (or default right)
        if len(self.patrol) < 2:
            return (1, 0)
        target = self.patrol[self.next_index]
        x, y = self.pos
        tx, ty = target
        if tx > x:
            return (1, 0)
        if tx < x:
            return (-1, 0)
        if ty > y:
            return (0, 1)
        if ty < y:
            return (0, -1)
        return (1, 0)


class GameMap:
    def __init__(self, template):
        self.grid = [list(row) for row in template]
        self.w = len(self.grid[0])
        self.h = len(self.grid)

    def in_bounds(self, p):
        x, y = p
        return 0 <= x < self.w and 0 <= y < self.h

    def is_floor(self, p):
        if not self.in_bounds(p):
            return False
        x, y = p
        return self.grid[y][x] != '#'

    def is_walkable(self, p):
        return self.is_floor(p) and self.get_tile(p) != 'G'

    def get_tile(self, p):
        x, y = p
        return self.grid[y][x]

    def draw(self, player_pos, guards, crouch):
        gmap = [row[:] for row in self.grid]
        px, py = player_pos
        if gmap[py][px] == '.':
            gmap[py][px] = 'P' if not crouch else 'p'
        for guard in guards:
            gx, gy = guard.pos
            # mark guard; if overlaps player, player wins/detected handled elsewhere
            if gmap[gy][gx] in ('.',):
                gmap[gy][gx] = 'E'
        lines = ["".join(row) for row in gmap]
        return "\n".join(lines)


def sign(x):
    return 0 if x == 0 else (1 if x > 0 else -1)


def visible_by_guard(guard, player_pos, game_map, crouch):
    gx, gy = guard.pos
    vx, vy = guard.facing_vector()
    # immediate adjacency detection (always detect)
    px, py = player_pos
    if abs(px - gx) + abs(py - gy) == 0:
        return True
    if abs(px - gx) + abs(py - gy) == 1:
        return True
    # if crouching, harder to detect: require being directly in sight within 3 tiles
    max_range = 3 if crouch else SIGHT_RANGE
    # scan along facing direction
    for dist in range(1, max_range + 1):
        tx = gx + vx * dist
        ty = gy + vy * dist
        if not game_map.in_bounds((tx, ty)):
            break
        tile = game_map.get_tile((tx, ty))
        if tile == '#':
            break  # blocked
        if (tx, ty) == player_pos:
            return True
    return False


def read_input():
    cmd = input("Move (WASD), C=crouch toggle, .=wait, Q=quit: ").strip().lower()
    if not cmd:
        return ''
    return cmd[0]


def main():
    game_map = GameMap(MAP_TEMPLATE)
    player = list(PLAYER_START)
    guards = [Guard(p) for p in GUARD_PATROLS]
    crouch = False
    turn = 0

    instructions = (
        "Sneak Game\n"
        "Reach G without being seen by enemies (E).\n"
        "Commands: W/A/S/D to move (up/left/down/right), C to toggle crouch (harder to see), '.' to wait, Q to quit.\n"
        "If you get adjacent to a guard or in their line of sight they detect you.\n"
        "Press Enter to start..."
    )
    print(instructions)
    input()

    while True:
        clear()
        print("Turn:", turn, "  Crouch:", "ON" if crouch else "OFF")
        print(game_map.draw(tuple(player), guards, crouch))
        # check current tile
        tile = game_map.get_tile(tuple(player))
        if tile == 'G':
            print("You reached the goal. You win!")
            break

        # Guards see before player moves? We'll do detection after guards move then check as player hides.
        cmd = read_input()
        if cmd == 'q':
            print("Quit.")
            break
        if cmd == 'c':
            crouch = not crouch
        elif cmd == '.':
            pass
        elif cmd in ('w', 'a', 's', 'd'):
            dx = {'a': -1, 'd': 1, 'w': 0, 's': 0}[cmd]
            dy = {'a': 0, 'd': 0, 'w': -1, 's': 1}[cmd]
            nx, ny = player[0] + dx, player[1] + dy
            if game_map.in_bounds((nx, ny)) and game_map.is_floor((nx, ny)):
                player[0], player[1] = nx, ny
            else:
                print("Bump! Can't move there.")
                time.sleep(0.3)
        else:
            print("Unknown command.")
            time.sleep(0.2)

        # Guards move
        for g in guards:
            g.step(game_map)

        # Detection check
        detected = False
        for g in guards:
            if visible_by_guard(g, tuple(player), game_map, crouch):
                detected = True
                break
        if detected:
            clear()
            print(game_map.draw(tuple(player), guards, crouch))
            print("You were spotted by a guard! Game over.")
            break

        turn += 1
        time.sleep(TICK_SLEEP)


if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        sys.exit(0)