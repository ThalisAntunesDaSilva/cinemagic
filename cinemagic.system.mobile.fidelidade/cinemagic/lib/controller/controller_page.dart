import 'package:mobx/mobx.dart';
part 'controller_page.g.dart';

class ControllerPage = _ControllerPage with _$ControllerPage;

abstract class _ControllerPage with Store {
  @observable
  int page = 0;

  @action
  void setPage(int value) => page = value;
}
