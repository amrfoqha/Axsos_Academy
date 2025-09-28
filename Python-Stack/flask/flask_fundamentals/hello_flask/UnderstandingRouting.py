from flask import Flask,Response
app=Flask(__name__)
@app.route('/')
def hello():
    return "helloss ,world!"
@app.route('/Champion')
def Champion():
    return "Champion"
@app.route('/say/<name>')
def Name(name):
    if not name.isalpha():
        return "Sorry! No response. Try again."
    return "Hi "+name+"!"
@app.route('/repeat/<int:num>/<word>')
def repeat(num,word):
    result=""
    for i in range(int(num)):
        result+=word+"<br>"
    if not word.isalpha():
        return "Sorry! No response. Try again."    
    return result


if __name__=="__main__":
    app.run(debug=True)