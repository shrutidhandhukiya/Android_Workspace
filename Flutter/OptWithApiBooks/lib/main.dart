import 'package:flutter/material.dart';
import 'package:flutter_screenutil/flutter_screenutil.dart';
import 'package:provider/provider.dart';
import 'package:restaurant/provider/BooksProvider.dart';
import 'package:restaurant/provider/HomeScreenProvider.dart';
import 'package:restaurant/splashscreen.dart';
import 'package:firebase_core/firebase_core.dart';

void main() async{
  // await Firebase;
  WidgetsFlutterBinding.ensureInitialized();
 await Firebase.initializeApp();
  await ScreenUtil.ensureScreenSize();
  runApp(
      MultiProvider(
          providers: [
             ChangeNotifierProvider<HomeScreenProvider>(create: (_) => HomeScreenProvider()),
           ],
           child:
           const MyApp(),
         ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(

        primarySwatch: Colors.orange,
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

  @override
  Widget build(BuildContext context) {

    return Scaffold(
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
          ],
        ),
      ),
    );
  }
}
