import 'package:flutter/material.dart';
import 'package:login1/screen/HomeScreen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(primarySwatch: Colors.blue,),
    // start 3 way Routs
    initialRoute: "home",
     routes:{
        "home": (BuildContext context)=>MyHomePage(title: "Demo",),
          "HomeScreen":(BuildContext context)=>HomeScreen(),

},
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
  var username=TextEditingController();
  var password= TextEditingController();

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(

        title: Text("Login Demo"),
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
                controller: username,
                decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Email',
                    hintText: 'Enter valid email'),
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(
                  left: 15.0, right: 15.0, top: 15, bottom: 0),
              child: TextField(
                controller: password,
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
                print(username.text);
                print(password.text);

               // Navigator.push(context, MaterialPageRoute(builder:(_)=>HomeScreen(username: username.text ,password: password.text,)));

               /* Navigator.push(context, MaterialPageRoute(builder: (_)=>HomeScreen(),
                settings: RouteSettings(
                  arguments: [
                    username.text,
                    password.text
                  ]
                )
                )
                );
*/
                Navigator.pushNamed(context, "HomeScreen",
                arguments:{
                  "UserName":username.text,
                  "Password":password.text
                }
                );

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
