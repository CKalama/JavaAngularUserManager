import {Injectable} from "@angular/core";
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable()
export class BasicAuthInterceptor implements HttpInterceptor{
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        //currently extracting the user from the localstorage using the user key
        //The current authenticated user
        let currentUser = localStorage.getItem('user');

        if(currentUser) {
            request = request.clone({
                setHeaders:{
                    Authorization: 'Basic ${currentUser}'
                }
            });
        }

        return next.handle(request);
    }
}