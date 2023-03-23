import { Component, OnInit, Output } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable, Subject } from 'rxjs';
import { user } from 'src/app/models';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  form!: FormGroup;
  formArray!: FormArray;

  @Output()
  onNewTodo = new Subject<user>()

  abc!: Observable<any>

  constructor(private fb: FormBuilder){ }

  ngOnInit(): void {
    this.form = this.createForm()
  }

  private createForm(): FormGroup {
    this.formArray = this.fb.array([], [ Validators.minLength(1) ])
    return this.fb.group({
      name: this.fb.control('', [ Validators.required, Validators.minLength(5)]),
      email: this.fb.control('', [ Validators.required ]),
      todo: this.formArray
    });
  }

  saveTodo(){
    const todo = this.form.value as user
    console.log(todo)
    this.onNewTodo.next(todo)
    this.form = this.createForm()
  }

  addTodoForm(){
    const g = this.fb.group({
      activity: this.fb.control('', [ Validators.required ]),
      date: this.fb.control('', [ Validators.required ])
    })
    return this.formArray.push(g);
  }

  deleteTodo(idx: number){
    this.formArray.removeAt(idx)
  }

}
