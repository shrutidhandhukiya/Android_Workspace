import 'package:flutter/material.dart';

class BottomNavigation extends StatefulWidget {

  @override
  State<BottomNavigation> createState() => _BottomNavigationState();
}

class _BottomNavigationState extends State<BottomNavigation> {
  int selectedIndex = 0;
  static List<Widget> Options =<Widget>[
    Text('HomePage',style: TextStyle(fontSize: 35, fontWeight: FontWeight.bold)),
    Text('Search',style: TextStyle(fontSize: 35, fontWeight: FontWeight.bold)),
    Text('Setting',style: TextStyle(fontSize: 35, fontWeight: FontWeight.bold)),
    Text('Setting',style: TextStyle(fontSize: 35, fontWeight: FontWeight.bold)),
  ];

  void _onItemTapped(int index){
    setState(() {
      selectedIndex =index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Flutter BottomNavigationBar Example"),
        backgroundColor: Colors.green,
      ),
      body: Center(
        child: Options.elementAt(selectedIndex),
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: [
          BottomNavigationBarItem(
              icon: Icon(Icons.home),
            label: 'Some String',
            backgroundColor: Colors.green
          ),

          BottomNavigationBarItem(
              icon:Icon(Icons.search_rounded),
              label: 'Some String',
              backgroundColor: Colors.green),

          BottomNavigationBarItem(
              icon:Icon(Icons.settings),
              label: 'Some String',
              backgroundColor: Colors.green),

          BottomNavigationBarItem(
              icon:Icon(Icons.settings),
              label: 'Some String',
              backgroundColor: Colors.green),
        ],

          type: BottomNavigationBarType.shifting,
          currentIndex: selectedIndex,
          selectedItemColor: Colors.black,
          iconSize: 40,
          onTap: _onItemTapped,
          elevation: 5

      ),

    );
  }
}

