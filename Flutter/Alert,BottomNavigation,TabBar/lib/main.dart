import 'package:alertdemo/BottomNavigation.dart';
import 'package:flutter/material.dart';

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
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      //home: const MyHomePage(title: 'Flutter Demo Home Page'),
      home: BottomNavigation(),
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

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Container(
        child: Center(
          child: ElevatedButton(onPressed: () {
            showDialog(context: context,
                builder: (ctx)=>AlertDialog(
                  title: Text("Alert Dialog Box"),
                  content: Text("You Have raised a Alert Dialog Box"),
                  actions: [
                    TextButton(onPressed: (){

                    }, child: Container(
                      color: Colors.green,
                      padding: const EdgeInsets.all(14),
                      child: Text("Oky"),
                    ),
                    ),
                    TextButton(onPressed: (){}, child: Text("No"))
                  ],
                ));

          },
          child: Text("Show alert Dialog box"),),
        ),
      ),
    );
  }
}

