import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listAsset(query) {
  return request({
    url: '/wh/asset/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getAsset(assetid) {
  return request({
    url: '/wh/asset/' + assetid,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addAsset(data) {
  return request({
    url: '/wh/asset',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateAsset(data) {
  return request({
    url: '/wh/asset',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delAsset(assetid) {
  return request({
    url: '/wh/asset/' + assetid,
    method: 'delete'
  })
}
