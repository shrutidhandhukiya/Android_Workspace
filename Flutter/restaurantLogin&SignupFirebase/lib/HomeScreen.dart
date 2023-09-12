import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:restaurant/BookScreen.dart';
import 'package:restaurant/Signup.dart';
import 'package:restaurant/provider/HomeScreenProvider.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  State<HomeScreen>createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {

  @override
  Widget build(BuildContext context) {
    var provider=Provider.of<HomeScreenProvider>(context);
    print("Build method call");
    return Scaffold(
      appBar: AppBar(
        title: Text("Home Screen"),
        backgroundColor: Colors.white,
        elevation: 0,
      ),
      body: Column(
        children: [
          Expanded(
            child: ListView.builder(
              itemCount: provider.todos.length,
              itemBuilder: (BuildContext context, int index) {
              return GestureDetector(
                onTap: (){
                  Navigator.push(context, MaterialPageRoute(builder: (_)=>BookScreen(provider.todos[index].id)));
                },
                child: Card(
                 child: Padding(
                   padding: const EdgeInsets.all(10.0),
                   child: Column(
                     crossAxisAlignment: CrossAxisAlignment.start,
                     children: [
                       Text(provider.todos[index].title),
                       Text(provider.todos[index].description),
                       Align(
                           alignment: Alignment.bottomRight,
                           child: Padding(
                             padding: const EdgeInsets.all(8.0),
                             child: Text(provider.todos[index].publishDate.toString()),
                           )),
                     ],
                   ),
                 ),

             ),
              );
              }),
           /*   children: [
                Item(title: "title", description: "description", date: "bfhbf"),
                Item(title: "title", description: "description", date: "bfhbf"),
                Item(title: "title", description: "description", date: "bfhbf"),
              ],*/
            ),
        ],
      ),
    );
  }
}
class Category {
  const Category({ required  this.title,required this.description,required this.date});

  final String title;
  final String description;
  final String date;

}
const List<Category> categorys = const <Category>[
  const Category(title: "title", description: "description", date: "date"),
  const Category(title: "title", description: "description", date: "date")

];

/*Item({required  String title,required String description,required String date }) {

  return Card(
    child: Padding(
      padding: const EdgeInsets.all(10.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text("$title"),
          Text("$description"),
          Align(
            alignment: Alignment.bottomRight,
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: Text("$date"),
              )),
        ],
      ),
    ),

  );
}*/
