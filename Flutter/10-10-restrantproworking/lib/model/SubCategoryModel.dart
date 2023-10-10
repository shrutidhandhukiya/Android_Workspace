// To parse this JSON data, do
//
//     final categoryDetailsModel = categoryDetailsModelFromJson(jsonString);

import 'dart:convert';

CategoryDetailsModel categoryDetailsModelFromJson(String str) => CategoryDetailsModel.fromJson(json.decode(str));

String categoryDetailsModelToJson(CategoryDetailsModel data) => json.encode(data.toJson());

class CategoryDetailsModel {
  int success;
  List<dynamic> error;
  Data data;

  CategoryDetailsModel({
    required this.success,
    required this.error,
    required this.data,
  });

  factory CategoryDetailsModel.fromJson(Map<String, dynamic> json) => CategoryDetailsModel(
    success: json["success"],
    error: List<dynamic>.from(json["error"].map((x) => x)),
    data: Data.fromJson(json["data"]),
  );

  Map<String, dynamic> toJson() => {
    "success": success,
    "error": List<dynamic>.from(error.map((x) => x)),
    "data": data.toJson(),
  };
}

class Data {
  int id;
  String name;
  String description;
  String image;
  String originalImage;
  Filters filters;
  String seoUrl;
  List<SubCategory> subCategories;

  Data({
    required this.id,
    required this.name,
    required this.description,
    required this.image,
    required this.originalImage,
    required this.filters,
    required this.seoUrl,
    required this.subCategories,
  });

  factory Data.fromJson(Map<String, dynamic> json) => Data(
    id: json["id"],
    name: json["name"],
    description: json["description"],
    image: json["image"],
    originalImage: json["original_image"],
    filters: Filters.fromJson(json["filters"]),
    seoUrl: jsonEncode(json["seo_url"]),
    subCategories: List<SubCategory>.from(json["sub_categories"].map((x) => SubCategory.fromJson(x))),
  );

  Map<String, dynamic> toJson() => {
    "id": id,
    "name": name,
    "description": description,
    "image": image,
    "original_image": originalImage,
    "filters": filters.toJson(),
    "seo_url": seoUrl,
    "sub_categories": List<dynamic>.from(subCategories.map((x) => x.toJson())),
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

class SubCategory {
  int categoryId;
  int parentId;
  String name;
  String seoUrl;
  String image;
  String originalImage;
  Filters filters;
  List<dynamic> categories;

  SubCategory({
    required this.categoryId,
    required this.parentId,
    required this.name,
    required this.seoUrl,
    required this.image,
    required this.originalImage,
    required this.filters,
    required this.categories,
  });

  factory SubCategory.fromJson(Map<String, dynamic> json) => SubCategory(
    categoryId: json["category_id"],
    parentId: json["parent_id"],
    name: json["name"],
    seoUrl: jsonEncode(json["seo_url"]),
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
