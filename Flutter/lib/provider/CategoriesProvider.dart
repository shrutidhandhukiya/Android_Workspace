
import 'package:flutter/cupertino.dart';
import 'package:orderdesing/model/GetCartModel.dart';
import 'package:orderdesing/model/ProductModel.dart';
import 'package:orderdesing/service/httpService.dart';
import '../Home.dart';
import '../Model/CategoriesModel.dart';
import '../model/SubCategoryModel.dart';

class CategoriesProvider extends ChangeNotifier{
  final service = httpService();
  bool isLoading = true;
  List<SubCategory>categories=[];
  int selectedCategory = 0;
  List<ProductDetail> products=[];


  CategoriesProvider(){
    getCategories();// api calling
    // getCart(int);
  }

  Future<void>getCategories() async{
    isLoading =true;
    notifyListeners();

    final response = await service.sendApiRequest(url: "api/rest/categories/", headers: {
    "Authorization" : "Bearer b1e935e5bd3fdc34b5de35c3f8917373c9a68151",
      // "Accept":"application/json"
    }, body: {}, method: "get");

    if(response!=null){
      var model =categoriesModelFromJson(response.body);
      //categories.addAll(model.data);
      var categoriesParent=model.data;
      for(var i in categoriesParent){
        final responseSubCategory = await service.sendApiRequest(url: "api/rest/categories/${i.categoryId}", headers: {
          "Authorization" : "Bearer b1e935e5bd3fdc34b5de35c3f8917373c9a68151",
          // "Accept":"application/json"
        }, body: {}, method: "get");
        var modelSubCategpory =categoryDetailsModelFromJson(responseSubCategory.body);
        categories.addAll(modelSubCategpory.data.subCategories);
      }
      print("List Response $categories");
      isLoading =false;
      notifyListeners();
    }

    isLoading =false;
    notifyListeners();
  }

  Future<void>getProducts(int category_id) async{
    isLoading =true;
    notifyListeners();

      var productresponse=await httpService().sendApiRequest(url: "api/rest/products/category/${category_id}/", headers: {
        "Authorization":"Bearer b1e935e5bd3fdc34b5de35c3f8917373c9a68151"
      }, body: {}, method: "get");

      if(productresponse!.statusCode==200){
        var productModel=productModelFromJson(productresponse.body);
        /* List<ProductDetail> list=[];
        list.addAll(productModel.data);
        list.addAll(productModel.data);
        list.addAll(productModel.data);
        list.addAll(productModel.data);
        products.add(list);*/

        //real one
        products.clear();
        products.addAll(productModel.data);

      }
      isLoading =false;
      notifyListeners();
  }

 Future<void>getCart(int) async{
    isLoading= true;
    notifyListeners();

    var getResponse= await httpService().sendApiRequest(url: "api/rest/cart/$int", headers: {
      "Authorization":"Bearer b1e935e5bd3fdc34b5de35c3f8917373c9a68151"
    }, body: {}, method: "POST");

    if(getResponse!.statusCode==200){
      var getCartModel=getCartModelFromJson(getResponse.body);

      // cart.clear();
      // cart.add(getCartModel);
    }
  }
}

class AddtoCardItems{
  Product product;
  int itemsCount;

  AddtoCardItems(this.product, this.itemsCount);
}
