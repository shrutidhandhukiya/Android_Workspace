import 'package:restaurant/model/BookListModel.dart';
import 'package:restaurant/model/BooksModel.dart';
import 'package:http/http.dart' as http;

class BookService{

 /* Future<List<BookListModel>> getAll() async{
    var url= "https://fakerestapi.azurewebsites.net/api/v1/Books";
    final uri = Uri.parse(url);
    final response = await http.get(uri);
    if(response.statusCode==200){
      var model= bookListModelFromJson(response.body);
      return model;
    }
    return [];


  }*/

  /*  Future<BookModel?> getsingle(String id) async{
    var url= "https://fakerestapi.azurewebsites.net/api/v1/Books/$id";
    final uri = Uri.parse(url);
    final response = await http.get(uri);
    if(response.statusCode==200){
      var model= bookModelFromJson(response.body);
      return model;
    }
    return null;
 }*/

  String base_url= "https://fakerestapi.azurewebsites.net/api/v1/";

  sendApiRequest({required String url, required dynamic body, required String method})async{
    final uri = Uri.parse(base_url+url);

    http.Response? response;
    var header={
      "Content-Type":"application/json"
    };
    switch(method){
      case "get":
        response=await http.get(uri);
        print("Response of Api ${response.body}");
        break;
        case "post":
        response=await http.post(uri);
        print("Response of Api ${response.body}");
        break;
        case "put":
        break;
        case "delete":
        break;
    }
    if(response!. statusCode==200){
      return response;
    }
    else
    {
      return null;
    }
  }
}