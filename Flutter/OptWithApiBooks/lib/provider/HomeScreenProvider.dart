
import 'package:flutter/material.dart';
import 'package:restaurant/services/Books_Service.dart';
import '../model/BookListModel.dart';


class HomeScreenProvider extends ChangeNotifier{
  final _service = BookService();
  bool isLoading = true;
  List<BookListModel>todos=[];
  HomeScreenProvider(){
    getAllTodos();
  }

  Future<void> getAllTodos() async {
    isLoading =true;
    notifyListeners();

    final response = await _service.sendApiRequest(url: "Books", body: {}, method: "get");
    if(response!=null){
      var model= bookListModelFromJson(response.body);
      todos.addAll(model);
    }
    print("List Response $todos");
    isLoading =false;
    notifyListeners();
  }

}