import { createSlice } from "@reduxjs/toolkit";
import { initialState } from "./article-init";
import { findAllArticles, findArticleById } from "./article-service";

const articleThunks = [findAllArticles, findArticleById]

const status = {
    pending: 'pending',
    fulfilled: 'fulfilled',
    rejected: 'rejected'
}

const handlePending = (state:any) => {
}

const handleFulfilled = (state:any, {payload}:any)=>{   // payload = 자바에 갔다온다 ex) 택배
    console.log('---------------- conclusion ----------------')
    state.array = payload
    console.log(state.array)
}

const handleRejected = (state:any) => {
}


export const articleSlice = createSlice({   // 슬라이스의 이름 = articles, 슬라이스의 키  = article (리듀서에 있음)
    name: "articles",
    initialState,
    reducers: {},
    extraReducers:builder =>{
        const {pending, rejected} = status;

        builder                                                 
        .addCase(findAllArticles.fulfilled, handleFulfilled)
        .addCase(findArticleById.fulfilled, handleFulfilled)
    }                                                           
})

export const getAllArticles = (state: any) => {
    console.log('---------------- Before useSelector ----------------')
    console.log(JSON.stringify(state.article.array))
    return state.article.array;
}

export const getOneArticles = (state: any) => {
    console.log('---------------- Before useSelector ----------------')
    console.log(JSON.stringify(state.article.array))
    return state.article.array;
}

export const {} = articleSlice.actions

export default articleSlice.reducer;