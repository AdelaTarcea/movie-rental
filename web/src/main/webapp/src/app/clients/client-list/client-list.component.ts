import {Component, OnInit} from '@angular/core';
import {Client} from "../shared/client.model";
import {ClientsService} from "../shared/clients.service";
import {Router} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  moduleId: module.id,
  selector: 'ubb-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css'],
})
export class ClientListComponent implements OnInit {
  errorMessage: string;
  clients: Array<Client>;
  selectedClient: Client;

  constructor(private clientService: ClientsService,
              private router: Router,
              private location: Location) {
  }

  ngOnInit(): void {
    this.getClients();
  }

  getClients() {
    this.clientService.getClients()
      .subscribe(
        clients => this.clients = clients,
        error => this.errorMessage = <any>error
      );
  }

  onSelect(client: Client): void {
    this.selectedClient = client;
  }

  gotoDetail(): void {
    this.router.navigate(['/client/detail', this.selectedClient.id]);
  }


  delete() {
    var id = this.selectedClient.id;
    this.clientService.delete(id).subscribe((client) => {
      console.log("success");
      this.getClients()
    });
  }
}

