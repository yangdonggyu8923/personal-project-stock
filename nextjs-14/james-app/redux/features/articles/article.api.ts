import { instance } from '@/redux/common/configs/axios-config'

export const fetchAllArticlesAPI = async (page: number) =>{     // axios = 동기식, 
    try{                                                        // axios를 thunk로 감싸면 비동기가 된다
        const response = await instance.get('/all-articles',{
            params: {page, limit: 10}
        })
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
    
}