import request from '@/utils/request'

// 查询打印机资产查询列表
export function listAorgasset(query) {
  return request({
    url: '/wh/aorgasset/list',
    method: 'get',
    params: query
  })
}

// 查询打印机资产查询详细
export function getAorgasset(id) {
  return request({
    url: '/wh/aorgasset/' + id,
    method: 'get'
  })
}

// 新增打印机资产查询
export function addAorgasset(data) {
  return request({
    url: '/wh/aorgasset',
    method: 'post',
    data: data
  })
}

// 修改打印机资产查询
export function updateAorgasset(data) {
  return request({
    url: '/wh/aorgasset',
    method: 'put',
    data: data
  })
}

// 删除打印机资产查询
export function delAorgasset(id) {
  return request({
    url: '/wh/aorgasset/' + id,
    method: 'delete'
  })
}
