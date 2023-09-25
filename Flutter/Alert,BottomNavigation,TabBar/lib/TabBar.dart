import 'package:flutter/material.dart';

class TabBar extends StatefulWidget {

  @override
  State<TabBar> createState() => _TabBarState();
}

class _TabBarState extends State<TabBar> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
     body: DefaultTabController(
       length: 4,
       child:TabBar(

       ),
       
     ),
    );
  }
}
