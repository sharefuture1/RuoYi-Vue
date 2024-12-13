import request from '@/utils/request'

// 查询bills列表
export function listZyy21(query) {
  return request({
    url: '/wh/zyy21/list',
    method: 'get',
    params: query
  })
}

// 查询bills详细
export function getZyy21(日期) {
  return request({
    url: '/wh/zyy21/' + 日期,
    method: 'get'
  })
}

// 新增bills
export function addZyy21(data) {
  return request({
    url: '/wh/zyy21',
    method: 'post',
    data: data
  })
}

// 修改bills
export function updateZyy21(data) {
  return request({
    url: '/wh/zyy21',
    method: 'put',
    data: data
  })
}

// 删除bills
export function delZyy21(日期) {
  return request({
    url: '/wh/zyy21/' + 日期,
    method: 'delete'
  })
}
