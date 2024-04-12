import { instance } from "@/app/components/common/configs/axios-config"
import { IUsers } from "../model/users-model"

export const findAllUsersAPI = async (page: number) => {
    try{
        const response = await instance.get('/users/list',{
            params: {page, size:10, limit: 10}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const findUserByIdAPI = async (id: number) => {
    try{
        const response = await instance.get('/users/detail',{
            params: {id}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const modifyUserAPI = async (user: IUsers) => {
    try{
        const response = (await instance.put('/users/modify', user))
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const countUserAPI = async () => {
    try{
        const response = await instance.get('/users/count',{
            params: {}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}