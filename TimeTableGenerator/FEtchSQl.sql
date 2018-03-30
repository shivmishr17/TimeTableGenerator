SELECT
    `subjects`.`sub_name`
    , `faculty`.`fac_name`
    , `monday`.`matrix_value`
    , `monday`.`fac_code`
    , `monday`.`sub_code`
FROM
    `ttgenerator`.`monday`
    INNER JOIN `ttgenerator`.`subjects` 
        ON (`monday`.`sub_code` = `subjects`.`sub_code`)
    INNER JOIN `ttgenerator`.`faculty` 
        ON (`monday`.`fac_code` = `faculty`.`fac_code`)
    INNER JOIN `ttgenerator`.`time_slots` 
        ON (`monday`.`matrix_value` = `time_slots`.`matrix_value`) 
WHERE monday.`Batch` = 'T' AND `monday`.`section` = 3;