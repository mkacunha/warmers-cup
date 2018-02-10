import { MenuService } from './menu/menu.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {


  showMenu: boolean;

  file: File;
  fileUrl: string;

  constructor(private _menuService: MenuService) {

  }

  ngOnInit() {
    this._menuService.isShowMenu.subscribe(show => this.showMenu = show);
  }

  selectFile(event) {
    if (event.target.files && event.target.files.length > 0) {
      this.file = event.target.files[0];

      const reader = new FileReader();

      reader.onload = (e: any) => {
        this.fileUrl = e.target.result;
      };

      reader.readAsDataURL(this.file);
    }
  }
}
