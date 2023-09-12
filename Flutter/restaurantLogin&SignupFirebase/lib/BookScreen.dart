import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:restaurant/provider/BooksProvider.dart';

class BookScreen extends StatefulWidget {

   int id;
  BookScreen(this.id);

  @override
  State<BookScreen> createState() => _BookScreenState();


}

class _BookScreenState extends State<BookScreen> {
  @override
  Widget build(BuildContext context) {

    var provider= Provider.of<BooksProvider>(context);
    //var products=provider.products[index]??[];

    return ChangeNotifierProvider(
        create: (_)=>BooksProvider(widget.id.toString()),
        child: Consumer(
        builder: (BuildContext context,BooksProvider provider, Widget? child)=>Scaffold(

          appBar: AppBar(
          title: Text("demo"),
            backgroundColor: Colors.white,
        elevation: 0,
      ),
      body: Column(
       children: [
      provider.todo==null? Container(
      ): Card(
      child: Padding(
          padding: const EdgeInsets.all(10.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(provider.todo!.title),
              Text(provider.todo!.description),
              Align(
                  alignment: Alignment.bottomRight,
                  child: Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Text(provider.todo!.publishDate.toString()),
                  )),
            ],
          ),
        ),
    )
       ],
      ),),)
    );
  }
}


