from flask import Flask,render_template,redirect,session,request

app=Flask(__name__)
app.secret_key='this is secret key'
@app.route('/')
def display():
    return render_template('index.html')

@app.route('/submit',methods=['POST'])
def display1():
    # if request.form['hidden']=='radiogroup':
    session['gender']=request.form['gender']
    session['colors']=request.form.getlist('color')
    session['name']=request.form['Name']
    session['Dojo_Location']=request.form['Dojo_Location']
    session['Favorite_language']=request.form['Favorite_language']
    session['comment']=request.form['comment']
    return redirect('/dojo')

@app.route('/dojo')
def display2():
    return render_template('info.html')


if __name__=="__main__":
    app.run(debug=True)