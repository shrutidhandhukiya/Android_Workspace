
import 'dart:convert';

CategoriesModel categoriesModelFromJson(String str) => CategoriesModel.fromJson(json.decode(str));

String categoriesModelToJson(CategoriesModel data) => json.encode(data.toJson());

class CategoriesModel {
  int success;
  List<dynamic> error;
  List<Datum> data;

  CategoriesModel({
    required this.success,
    required this.error,
    required this.data,
  });

  factory CategoriesModel.fromJson(Map<String, dynamic> json) => CategoriesModel(
    success: json["success"],
    error: List<dynamic>.from(json["error"].map((x) => x)),
    data: List<Datum>.from(json["data"].map((x) => Datum.fromJson(x))),
  );

  Map<String, dynamic> toJson() => {
    "success": success,
    "error": List<dynamic>.from(error.map((x) => x)),
    "data": List<dynamic>.from(data.map((x) => x.toJson())),
  };
}

class Datum {
  int categoryId;
  int parentId;
  String name;
  String seoUrl;
  String image;
  String originalImage;
  Filters filters;
  List<dynamic> categories;

  Datum({
    required this.categoryId,
    required this.parentId,
    required this.name,
    required this.seoUrl,
    required this.image,
    required this.originalImage,
    required this.filters,
    required this.categories,
  });

  factory Datum.fromJson(Map<String, dynamic> json) => Datum(
    categoryId: json["category_id"],
    parentId: json["parent_id"],
    name: json["name"],
    seoUrl:jsonEncode( json["seo_url"]),
    image: json["image"],
    originalImage: json["original_image"],
    filters: Filters.fromJson(json["filters"]),
    categories: List<dynamic>.from(json["categories"].map((x) => x)),
  );

  Map<String, dynamic> toJson() => {
    "category_id": categoryId,
    "parent_id": parentId,
    "name": name,
    "seo_url": seoUrl,
    "image": image,
    "original_image": originalImage,
    "filters": filters.toJson(),
    "categories": List<dynamic>.from(categories.map((x) => x)),
  };
}

class Filters {
  List<dynamic> filterGroups;

  Filters({
    required this.filterGroups,
  });

  factory Filters.fromJson(Map<String, dynamic> json) => Filters(
    filterGroups: List<dynamic>.from(json["filter_groups"].map((x) => x)),
  );

  Map<String, dynamic> toJson() => {
    "filter_groups": List<dynamic>.from(filterGroups.map((x) => x)),
  };
}
