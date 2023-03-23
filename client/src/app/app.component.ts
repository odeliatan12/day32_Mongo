import { Component } from '@angular/core';
import { TodoService } from './components/todo/todo.service';
import { user } from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';

  constructor(private todoSvc: TodoService){ }

  placeTodo(value: user): Promise<any>{
    return this.todoSvc.addTodo(value)
      .then(result => {
        console.log(result);
      })
  }
}
