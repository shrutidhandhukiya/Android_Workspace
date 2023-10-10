import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:orderdesing/main.dart';

class SplashScreen extends StatefulWidget {

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {

    super.initState();

    Future.delayed(Duration(seconds: 1),
        ()=>Navigator.pushReplacement(context,
            MaterialPageRoute(builder: (context)=>MyHomePage(title: 'demo',))));
  }
  @override
  Widget build(BuildContext context) {
  return Container(
    color: Colors.white,
    child: Image.asset("assets/applogo.jpg"),
  );

  }
}
