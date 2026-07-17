var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null || obj === undefined || typeof classFunction !== 'function') {
        return false;
    }
    let currProto = Object.getPrototypeOf(Object(obj));
    while (currProto !== null) {
        if (currProto === classFunction.prototype) {
            return true;
        }
        currProto = Object.getPrototypeOf(currProto);
    }

    return false;
};
