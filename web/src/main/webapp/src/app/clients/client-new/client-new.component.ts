import {Component} from "@angular/core";
import {Location} from "@angular/common";
import {ClientsService} from "../shared/clients.service";

@Component({
  moduleId: module.id,
  selector: 'ubb-client-new',
  templateUrl: './client-new.component.html',
  styleUrls: ['./client-new.component.css'],
})
export class ClientNewComponent {

  constructor(private location: Location,
              private clientService: ClientsService) {

  }

  goBack(): void {
    console.log("mesaj");

    this.location.back();
  }

  save(name, cnp) {
    console.log("saveNewClient");

    this.clientService.save(name, cnp)
      .subscribe(client => {
        console.log("client saved");
        this.location.back();
      });

  }
}
