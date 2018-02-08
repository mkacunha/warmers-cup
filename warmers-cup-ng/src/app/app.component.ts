import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  file: File;
  fileUrl: string;

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
