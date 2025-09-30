from flask import Flask, render_template, request, redirect,session

app = Flask(__name__)  
app.secret_key='this is secret key'
@app.route('/')
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])         
def checkout():
    session['straw']=request.form['strawberry']
    session['rasp']=request.form['raspberry']
    session['apple']=request.form['apple']
    session['fname']=request.form['first_name']
    session['lname']=request.form['last_name']
    session['id']=request.form['student_id']
    count=int(session['straw'])+int(session['rasp'])+int(session['apple'])
    print(f"charging {session['fname']} {session['lname']} for {count} fruits ")
    print(request.form)
    return redirect("/checkoutnew")
@app.route('/checkoutnew')         
def checkoutnew():
    return render_template("checkout.html")

@app.route('/fruits')         
def fruits():
    imgs=['apple.png','blackberry.png','raspberry.png','strawberry.png']
    return render_template("fruits.html",imgsrcs=imgs)

if __name__=="__main__":   
    app.run(debug=True)    