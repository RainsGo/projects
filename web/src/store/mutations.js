import * as Types from './mutation-types'

const mutations = {
    [Types.INCREMENT] (state) {
        return state.count++
    },
    [Types.DECREMENT] (state) {
        return state.count--
    }
}

export default mutations
