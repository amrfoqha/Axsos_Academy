from flask import Flask,render_template,request,session,redirect
app=Flask(__name__)
app.secret_key="hii how are you"

@app.route('/')
def counter():
    if 'counter' in session:
        session['counter']+=1
    else: session['counter']=1
    return render_template('index.html')

@app.route('/destroy_session')
def destroy():
    
    session.clear()
    return redirect('/')

@app.route('/inc_two')
def inc_2():
    if 'counter' in session:
        session['counter']+=2
    else: session['counter']=2
    return redirect('/')


if __name__=="__main__":
    app.run(debug=True)