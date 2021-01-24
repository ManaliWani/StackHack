import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { SimplePlaceholderMapper } from '@angular/compiler/src/i18n/serializers/serializer';
import { RouteConfigLoadStart, Router } from '@angular/router';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {

  content: string;
  totalPrice : number = 0;

  public price=
  {
    "tea":10,
    "coffee":15,
    "milk":20,
    "hotchocolatemilk":25,
    "coldcoffee":30,
    "lemonjuice":10,
    "mosambijuice":30,
    "pineapplejuice":30,
    "watermelonjuice":30,
    "chocolatemilkshake":25,
    "bananamilkshake":25,
    "mangomilkshake":30,
    "butterscotchmilkshake":30,
    "vegfriedrice":40,
    "vegschezwanrice":50,
    "vegtriplerice":60,
    "vegmanchurianrice":60,
    "vegcombinationrice":50,
    "paneermanchurianrice":60,
    "jeerarice":80,
    "veghakkanoodles":40,
    "vegschezwannoodles":50,
    "vegmaggi":40,
    "masaladosa":60,
    "idlisambhar":60,
    "wadasambhar":50,
    "puribhaji":50
  }

  public item:string;

  public selectedItems=[]
  public placeOrder:boolean = false;

  public msg : string = null;




  constructor(private userService: UserService,private _router:Router) { }

  ngOnInit(): void {
    this.userService.getUserBoard().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

  check(item)
  {
    console.log(item)
  }

  public onChanged(value:string,status:boolean){

    this.item = value;
    console.log("In function")
    if(status)
     { this.totalPrice=this.totalPrice+this.price[this.item]
        this.selectedItems.push(this.item)
     }
    else
     { this.totalPrice=this.totalPrice-this.price[this.item];
      const index: number = this.selectedItems.indexOf(this.item);
      this.selectedItems.splice(index,1)
     }

     console .log(this.selectedItems);
    console.log(this.item)
}

public placeOrd() :void
{ 
  this.placeOrder = true;

}




confirm()
{
  window.alert("Order Placed Successfully !!!! \n"+this.msg)
  this._router.navigate(['home'])
}

online()
{
  this.msg = "Application is in demo mode. Payment gateways will be added"
}
cash()
{
  this.msg = "ThankYou for using Cafe Street"
}



}
