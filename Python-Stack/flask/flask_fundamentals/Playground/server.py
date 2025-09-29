from flask import Flask,render_template

app=Flask(__name__)

@app.route("/play")
def play():
    return render_template("index.html",newcolor=False,iterate=False)

@app.route("/play/<int:num>")
def new_square(num=3):
    return render_template("index.html",iterate=num)

@app.route("/play/<int:num>/<color>")
def num_with_color(num,color):
    return render_template("index.html",iterate=num,newcolor=color)

if __name__=="__main__":
    app.run(debug=True)