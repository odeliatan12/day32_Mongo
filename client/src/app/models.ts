export interface user{
    name: string
    email: string
    todoList: todo[]
}

export interface todo{
    activity: string
    date: string
}