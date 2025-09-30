from flask import Flask,render_template

app=Flask(__name__)

@app.route('/')
def display8by8():
    return render_template('index.html',n=8,k=8,colorx="red",colory="black")

@app.route('/<int:x>')
def display8byn(x):
    return render_template('index.html',n=x,k=8,colorx="red",colory="black")

@app.route('/<int:x>/<int:y>')
def displaynbyn(x,y):
    return render_template('index.html',n=x,k=y,colorx="red",colory="black")
@app.route('/<int:x>/<int:y>/<color1>')
def display_nbyn_with_color(x,y,color1):
    return render_template('index.html',n=x,k=y,colorx=color1,colory="black")

@app.route('/<int:x>/<int:y>/<color1>/<color2>')
def display_nbyn_with_colors(x,y,color1,color2):
    return render_template('index.html',n=x,k=y,colorx=color1,colory=color2)


if __name__=="__main__":
    app.run(debug=True)