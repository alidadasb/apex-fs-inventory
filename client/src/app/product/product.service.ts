import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {throwError} from "rxjs";
import {catchError, retry} from "rxjs/operators";
import {Product} from "../../models/product";
import {Injectable} from "@angular/core";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable()
export class ProductService {

  constructor(private http: HttpClient) {
  }
  serverUrl = 'http://localhost:8080/';

  private static handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  }

  addProduct(product: Product) {
    return this.http.post<Product>(this.serverUrl, product, httpOptions)
      .pipe(catchError(ProductService.handleError));
  }

  loadAll() {
    return this.http.get<Product[]>(this.serverUrl, httpOptions)
      .pipe(catchError(ProductService.handleError));
  }

}
