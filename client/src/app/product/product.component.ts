import { Component, OnInit } from '@angular/core';
import {Product} from '../../models/product';
import {ProductService} from './product.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  model = this.createNew();
  submitted = false;
  btnName = 'Submit';
  products = [];

  constructor(private productService: ProductService ) { }

  ngOnInit(): void {
    this.readAll();
  }

  private readAll() {
    return this.productService.loadAll().subscribe((list) => {
      this.products = list;
    });
  }

  createNew() {
    return new Product(null, null, null);
  }

  onSubmit(productForm: NgForm) {
    this.submitted = true;

    this.productService.addProduct(this.model)
      .subscribe(product => {
        this.products.push(product);
        console.log('object saved', product);
        this.model = this.createNew();
        this.submitted = false;
        productForm.resetForm();
      });

    console.log('submitted');
  }

  get diagnostic() { return JSON.stringify(this.model); }

}
