export const count = state => state.count

export const todos = (state) => {
    return state.todos
}

export const todosDone = (state) => {
    return state.todos.filter(todos => todos.done)
}

export const todosDoneCount = (state) => {
    return todosDone(state).length
}
