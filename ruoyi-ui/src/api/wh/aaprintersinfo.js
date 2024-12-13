import request from '@/utils/request'

// 查询打印机信息查询列表
export function listAaprintersinfo(query) {
  return request({
    url: '/wh/aaprintersinfo/list',
    method: 'get',
    params: query
  })
}

// 查询打印机信息查询详细
export function getAaprintersinfo(printerid) {
  return request({
    url: '/wh/aaprintersinfo/' + printerid,
    method: 'get'
  })
}

// 新增打印机信息查询
export function addAaprintersinfo(data) {
  return request({
    url: '/wh/aaprintersinfo',
    method: 'post',
    data: data
  })
}

// 修改打印机信息查询
export function updateAaprintersinfo(data) {
  return request({
    url: '/wh/aaprintersinfo',
    method: 'put',
    data: data
  })
}

// 删除打印机信息查询
export function delAaprintersinfo(printerid) {
  return request({
    url: '/wh/aaprintersinfo/' + printerid,
    method: 'delete'
  })
}
