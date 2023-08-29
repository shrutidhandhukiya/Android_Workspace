import 'package:flutter/material.dart';
import 'package:restaurant/loginscreen.dart';
import 'package:restaurant/main.dart';

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
            MaterialPageRoute(builder: (context)=>LoginScreen())));
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      child: Image.network("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxi3L6ymTQ_q3WriBhcHCDUX6iRYhkN7hmrA&usqp=CAU%27"),
    );
  }
}
