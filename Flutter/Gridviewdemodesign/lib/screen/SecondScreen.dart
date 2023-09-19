import 'package:flutter/material.dart';

import '../main.dart';

class SecondScreen extends StatefulWidget{

  BookingOrder? name;
  //SecondScreen({this.name});
  SecondScreen();

  @override
  State<StatefulWidget> createState()=>SecondScreenState();
}

class SecondScreenState extends State<SecondScreen>
{
  // Second ways start
  Map<String,dynamic> args={};

 @override
  void initState() {
    super.initState();
    Future.delayed(Duration(seconds: 0),(){
      args = ModalRoute.of(context)!.settings.arguments as Map<String,dynamic>;
      setState(() {

      });
    });
    // end Second Way
  }

  @override
  Widget build(BuildContext context) {
   // // TODO: implement build
   // throw UnimplementedError();

    return Scaffold(
      appBar: AppBar(
        title: Text("demo"),
      ),
     body: Center(
      // child: Text('${widget.name}'),
       //text ma
       child: Text('${args['name']}'),
       //child: Text('${widget.name?.name}'),
     ),
     // body: Text(widget.name!),
    );
  }
}