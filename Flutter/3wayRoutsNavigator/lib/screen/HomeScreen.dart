import 'package:flutter/material.dart';

class HomeScreen extends StatefulWidget{
 // String username;
 // String password;
  HomeScreen();

 // HomeScreen({required this.username, required this.password});

   @override
  State<StatefulWidget> createState()=>HomeScreenState();
  // throw UnimplementedError();
  }
  class HomeScreenState extends State<HomeScreen> {
  @override
  Widget build(BuildContext context) {
// argument 2 Way but List
    //   var args= ModalRoute.of(context)?.settings.arguments as List;
    // named 3 ways
    Map<String,dynamic>? args= ModalRoute.of(context)?.settings.arguments==null?null: ModalRoute.of(context)?.settings.arguments as Map<String,dynamic>;
    //throw UnimplementedError();

    return Scaffold(
      drawer: Drawer(),
      appBar: AppBar(
        title: Text("Home Page"),
      ),
      body: ListView(
        children: [
          //1 Way
       //  Text(widget.username!),
         // Text(widget.password!),

          //2 way
          //argument text
         // Text(args.toString()),

          //3way
         // Text("this Data pass from arguments using pushname"),
          args==null?Text(' '):Text("${args['UserName'] } ,${args['Password'] } "),
        ],
      ),
    );
  }
}