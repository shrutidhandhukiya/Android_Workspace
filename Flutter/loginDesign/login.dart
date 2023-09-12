import 'package:flutter/material.dart';
import 'package:signin/screen/HomeScreen.dart';

class MyLogin extends StatefulWidget {
  const MyLogin({Key? key}) : super(key: key);

  @override
  State<MyLogin> createState() => _MyLoginState();
}

class _MyLoginState extends State<MyLogin> {
  var username=TextEditingController();
  var password=TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(

      backgroundColor: Colors.white,
        appBar: AppBar(
          title: Text("Login Page"),
        ),
      body: SingleChildScrollView(
        child: Column(
          children: <Widget>[
        Padding(
        padding: const EdgeInsets.only(top: 60.0),
        child: Center(
          child: Container(
            width: 200,
            height: 150,
          )
        ),
        ),
           Padding(
             padding: EdgeInsets.symmetric(horizontal: 15),
             child: TextField(
               decoration: InputDecoration(
                 border: OutlineInputBorder(),
                 labelText: 'NAME',
                 hintText: 'First Name'),
             ),
           ),
            Padding(
              padding: const EdgeInsets.only(
                  left: 15.0, right: 15.0, top: 15, bottom: 0),
              child: TextField(
                obscureText: true,
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Password',
                  hintText: 'Enter Password'),

                ),
              ),
            SizedBox(
              height: 50,
            ),

            MaterialButton(
              onPressed: (){
              //  print(username.text);
                //print(password.text);

                Navigator.push(context, MaterialPageRoute(builder:(_)=>HomeScreen(username: username.text ,password: password.text,)));
              },
              child: Container(
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

    );
  }
}
