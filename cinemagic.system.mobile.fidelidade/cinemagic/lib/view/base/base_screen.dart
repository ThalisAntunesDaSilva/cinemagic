import 'package:cinemagic/controller/controller_page.dart';
import 'package:cinemagic/view/home/home_screen.dart';
import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';

class BaseScreen extends StatelessWidget {
  final PageController pageController = PageController();
  final ControllerPage controllerPage = GetIt.I<ControllerPage>();
  @override
  Widget build(BuildContext context) {
    return PageView(
      physics: NeverScrollableScrollPhysics(),
      controller: pageController,
      children: [
        HomeScreen(),
      ],
    );
  }
}
