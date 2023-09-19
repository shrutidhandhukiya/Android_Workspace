import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'Providers/HomeScreenProvider.dart';

void main() {
  runApp(
    //assign mimimunm 1 provider
    //create provider which one call only one time during run

    // MultiProvider(
    //   providers: [
    //     ChangeNotifierProvider<HomeScreenProvider>(create: (_) => HomeScreenProvider()),
    //   ],
    //   child:
    //   const MyApp(),
    // ),
    const MyApp(),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
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
    print("Build method call");

    // var provider=Provider.of<HomeScreenProvider>(context);
    // create always new provider as object when need to get dynamic data
    return ChangeNotifierProvider(
      create: (_)=>HomeScreenProvider(),
      child: Consumer(
        builder: (BuildContext context,HomeScreenProvider provider, Widget? child)=> Scaffold(
          appBar: AppBar(
            title: Text(widget.title),
          ),
          body: Center(
             child: Column(
             mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                const Text(
                  'You have pushed the button this many times:',
                ),
                Text(
                  '${provider.count}',
                  style: Theme.of(context).textTheme.headline4,
                ),
              ],
            ),
          ),
          floatingActionButton: Row(
            children: [
              FloatingActionButton(
                onPressed: provider.incre ,
                tooltip: 'Increment',
                child: const Icon(Icons.add),
              ),

              FloatingActionButton(
                onPressed:(){
                  setState(() {
                  });
                },
                tooltip: 'Increment',
                child: const Icon(Icons.add),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
