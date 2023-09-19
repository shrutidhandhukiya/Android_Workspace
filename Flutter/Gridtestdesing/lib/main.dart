import 'package:flutter/material.dart';
import 'package:gridtest/Grid.dart';
import 'package:gridtest/OrderSystem.dart';

void main() {
  runApp(const MyApp());
}
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(

        primarySwatch: Colors.blue,
      ),
      debugShowCheckedModeBanner: false,
      home: OrderSystem(),
      // home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}
class _MyHomePageState extends State<MyHomePage> {
  final _formKey = GlobalKey<FormState>();

  var username=TextEditingController();
  var password= TextEditingController();
  bool passToggle= true;
 //var _formkey = GlobalKey()

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text("Login Screen"),
      ),
      body: Form(
        key: _formKey,
        child: SingleChildScrollView(
          child: Column(
            children: <Widget>[
              Padding(
                padding: const EdgeInsets.only(top: 60.0),
                child: Center(
                    child: Container(
                      width: 200,
                      height: 150,
                      child: Column(
                        children: [
                          Image.asset('images/image.png'),
                        ],
                      ),
                    )
                ),
              ),
              Padding(
                padding: EdgeInsets.symmetric(horizontal: 15),

                child: TextFormField(
                  controller: username,
                  decoration: InputDecoration(
                      labelText: 'Email',
                      hintText: 'Enter valid email',
                      border: OutlineInputBorder(),
                      prefixIcon: Icon(Icons.email),
                  ),
                  validator: (value){
                    if(value!.isEmpty){
                      return "Enter Email";
                    }else if(username.text != "abc"){
                        return "Invalid UserName";
                    }
                    return null;
                  },
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(
                    left: 15.0, right: 15.0, top: 15, bottom: 0),
                child: TextFormField(
                  controller: password,
                  obscureText: passToggle,
                  decoration: InputDecoration(
                      labelText: 'Password',
                      hintText: 'Enter Password',
                      border: OutlineInputBorder(),
                     prefixIcon: Icon(Icons.lock),
                     suffixIcon: InkWell(
                       onTap: (){
                        setState(() {
                          passToggle = !passToggle;
                        });
                      },
                      child: Icon(passToggle ? Icons.visibility : Icons.visibility_off),
                    ),

                  ),
                  validator: (value){
                    if(value!.isEmpty)
                      {
                        return "Enter Password";
                      }
                    else if(password.text.length <6){
                      return " password length";
                    }
                    else if(password.text!="123456"){
                      return " invalid Password";
                    }
                  },
                ),
              ),
              SizedBox(
                height: 50,
              ),

              MaterialButton(
                onPressed: (){
                  if(_formKey.currentState!.validate()){
                    Navigator.push(context, MaterialPageRoute(builder: (_) => Grid()));
                  }
                  },

                child: Container(
                 padding: EdgeInsets.only(left: 95,top: 14),
                  height: 60,
                  width: 250,
                  decoration: BoxDecoration(
                      color: Colors.blue, borderRadius:
                  BorderRadius.circular(20)),
                  child: Text('Login',
                    style: TextStyle(color: Colors.white, fontSize: 25),
                  ),
                ),

              ),
              SizedBox(
                height: 50,
              ),
              Text('New User ? Create Account ')
            ],
          ),
        ),
      ),
    );
  }
}
