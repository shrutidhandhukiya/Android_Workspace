import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:restaurant/model/BooksModel.dart';
import 'package:restaurant/services/Books_Service.dart';

class BooksProvider extends ChangeNotifier{
  final service = BookService();
  bool isLoading = false;

  BookModel? todo;
  BooksProvider(String id){

    getAllBooks(id);
  }

  Future<void> getAllBooks(String id) async {
    isLoading =true;
    notifyListeners();

    final response = await service.sendApiRequest(url: "Books/$id",body: {},method: "get");
    if(response!=null){
      var model=BookModel.fromJson(jsonDecode(response.body));
      todo=model;
    }
    print("List Response $todo");
    isLoading =false;
    notifyListeners();
  }
}