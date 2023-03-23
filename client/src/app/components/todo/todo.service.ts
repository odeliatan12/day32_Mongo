import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";
import { user } from "src/app/models";

@Injectable()
export class TodoService{

    constructor(private http: HttpClient){ }

    addTodo(user : user): Promise<any>{
        return firstValueFrom(
            this.http.post<user>("http://localhost:8080/post", user)
        )
    }

}