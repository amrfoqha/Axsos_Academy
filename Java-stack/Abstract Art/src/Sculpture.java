public class Sculpture extends Art {
    String material;

    public Sculpture(String material,String title, String author,String description){
        super.title=title;
        super.author=author;
        super.description=description;
        this.material=material;
    }

    @Override
    public void viewArt() {
        System.out.println("this is a Sculpture art");
        System.out.println("title "+super.title);
        System.out.println("author "+super.author);
        System.out.println("description "+super.description);
        System.out.println("material "+material);
        System.out.println("*********************************************************");
    }
}
