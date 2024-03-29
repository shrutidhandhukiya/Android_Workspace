import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:orderdesing/HungerzMenu.dart';
import 'package:orderdesing/splashscreen.dart';
import 'Home.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  SystemChrome.setPreferredOrientations([
    DeviceOrientation.landscapeLeft,
    DeviceOrientation.landscapeRight,

  ]).then((value) => runApp(MyApp()));
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
       // useMaterial3: true,
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.orange,
          primary: Colors.orange,

        ),
        appBarTheme: AppBarTheme(
          backgroundColor: Colors.white,elevation: 0
        )
      ),
      debugShowCheckedModeBanner: false,
      home: SplashScreen(),
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
  String?  gender="";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Change Language",style:TextStyle(color: Colors.black,fontSize: 22,fontWeight:FontWeight.w700),),
      ),
    body: Column(
      children: [
        Expanded(
          child: ListView(
            children: [
              Padding(
                padding: const EdgeInsets.only(left: 9.0,top: 5.0),
                child: Row(
                  children: [
                    Radio(
                      // title:  Text("Male"),
                      value:"English",
                      groupValue:"$gender",
                      onChanged: (value){
                        setState(() {
                          gender=value.toString();
                        });
                      },
                    ),
                    Text("English")
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(left: 9.0,top: 5.0),
                child: Row(
                  children: [
                    Radio(
                      // title:  Text("Male"),
                      groupValue:"$gender",
                      value: "turk",
                      onChanged: (value){
                        setState(() {
                          gender=value.toString();
                        });
                      },
                    ),Text("Espanol")
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(left: 9.0,top: 5.0),
                child: Row(
                  children: [
                    Radio(
                      // title:  Text("Male"),
                      groupValue:"$gender",
                      value: "Espanol",
                      onChanged: (value){
                        setState(() {
                          gender=value.toString();
                        });
                      },
                    ),
                    Text("Espanol")
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(left: 9.0,top: 5.0),
                child: Row(
                  children: [
                    Radio(
                      // title:  Text("Male"),
                      groupValue:"$gender",
                      value: "italin",
                      onChanged: (value){
                        setState(() {
                          gender=value.toString();
                        });
                      },
                    ),
                    Text("italin")
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(left: 9.0,top: 5.0),
                child: Row(
                  children: [
                    Radio(
                      // title:  Text("Male"),
                      groupValue:"$gender",
                      value: "Francais",
                      onChanged: (value){
                        setState(() {
                          gender=value.toString();
                        });
                      },
                    ),
                    Text("Francais")
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(left: 9.0,top: 5.0),
                child: Row(
                  children: [
                    Radio(
                      // title:  Text("Male"),
                      groupValue:"$gender",
                      value: "kiswahili",
                      onChanged: (value){
                        setState(() {
                          gender=value.toString();
                        });
                      },
                    ),
                    Text("kiswahili")
                  ],
                ),
              ),
            ],
          ),
        ),
        SizedBox(
          width:double.infinity,
          child: ElevatedButton(onPressed: (){
            Navigator.push(context, MaterialPageRoute(builder: (_)=>HungerzMenu()));
            },
              child: Padding(
                padding: const EdgeInsets.only(top: 20.0,bottom: 20.0),
                child: Text("Submit",style: TextStyle(fontSize: 18),),
              )),
        )
      ],
    ),


    );
  }
}
